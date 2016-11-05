/**
 * This document is a part of the source code and related artifacts for Emilent.
 * www.brilapps.com
 * Copyright © 2015 brilapps
 *
 */
package com.bluespacetech.security.resources.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bluespacetech.contact.resources.ContactResource;
import com.bluespacetech.security.controller.UserAccountController;
import com.bluespacetech.security.model.AccessControl;
import com.bluespacetech.security.model.UserAccount;
import com.bluespacetech.security.model.UserAccountUserGroup;
import com.bluespacetech.security.model.UserGroup;
import com.bluespacetech.security.resources.AccessControlResource;
import com.bluespacetech.security.resources.UserAccountResource;
import com.bluespacetech.security.resources.UserAccountUserGroupResource;
import com.bluespacetech.security.resources.UserGroupResource;

/**
 * @author pradeep created date 27-Jan-2015
 */
public class UserAccountResourceAssembler extends
ResourceAssemblerSupport<UserAccount, UserAccountResource> {

	public UserAccountResourceAssembler() {
		super(UserAccountController.class, UserAccountResource.class);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.hateoas.ResourceAssembler#toResource(java.lang.Object
	 * )
	 */
	@Override
	public UserAccountResource toResource(final UserAccount userAccount) {
		final UserAccountResource userAccountResource = new UserAccountResource();
		userAccountResource.setObjectId(userAccount.getId());
		userAccountResource.setVersion(userAccount.getVersion());
		userAccountResource.setUsername(userAccount.getUsername());
		if (userAccount.getContact() != null) {
			userAccountResource
					.setContact(ContactResource.convertToPeronResource(userAccount.getContact(), false, true, true));
			userAccountResource.setContactId(userAccount.getContact().getId());
		}
		userAccountResource.setAccountExpired(userAccount.isAccountExpired());
		userAccountResource.setAccountLocked(userAccount.isAccountLocked());
		userAccountResource.setActive(userAccount.isActive());
		userAccountResource.setCredentialsExpired(userAccount.isCredentialsExpired());
		userAccountResource.setUserAccountType(userAccount.getUserAccountType());
		final Link link = linkTo(UserAccountController.class).slash(
				userAccount.getId()).withSelfRel();
		userAccountResource.add(link.withSelfRel());
		return userAccountResource;
	}

	public UserAccountResource toCompleteResource(final UserAccount userAccount,final Map<Long,UserGroup> userGroupsMap) {
		final UserAccountResource userAccountResource = this.toResource(userAccount);
		final List<UserAccountUserGroupResource> userAccountUserGroupResources = new ArrayList<UserAccountUserGroupResource>();
		final List<AccessControlResource> accessControlResources = new ArrayList<AccessControlResource>();

		final UserGroupResourceAssembler userAccountResourceAssembler = new UserGroupResourceAssembler();
		if(userAccount.getUserAccountUserGroups()!=null) {
			for(final UserAccountUserGroup userAccountUserGroup : userAccount.getUserAccountUserGroups()){
				final UserAccountUserGroupResource userAccountUserGroupResource = new UserAccountUserGroupResource();
				final UserGroupResource userGroupResource = userAccountResourceAssembler.toResource(userGroupsMap.get(userAccountUserGroup.getUserGroupId()));
				userAccountUserGroupResource.setUserGroup(userGroupResource);
				userAccountUserGroupResource.setObjectId(userAccountUserGroup.getId());
				userAccountUserGroupResources.add(userAccountUserGroupResource);
			}
		}
		userAccountResource.setUserAccountUserGroups(userAccountUserGroupResources);
		if(userAccount.getAccessControls()!=null) {
			for(final AccessControl accessControl : userAccount.getAccessControls()){
				final AccessControlResource accessControlResource = new AccessControlResource();
				accessControlResource.setBranchId(accessControl.getBranchId());
				accessControlResource.setVersion(accessControl.getVersion());
				accessControlResource.setObjectId(accessControl.getId());
				accessControlResources.add(accessControlResource);
			}
		}
		userAccountResource.setAccessControls(accessControlResources);
		return userAccountResource;
	}
	/**
	 * Copy all the properties from source Financial year to destination
	 * Financial year.
	 *
	 * @param sourceUserAccount
	 *            source Financial year.
	 * @param destinationUserAccount
	 *            destination Financial year.
	 */
	public static void copyUserAccountInto(
			final UserAccount sourceUserAccount,
			final UserAccount destinationUserAccount) {
		destinationUserAccount.setAccountExpired(sourceUserAccount.isAccountExpired());
		destinationUserAccount.setAccountLocked(sourceUserAccount.isAccountLocked());
		destinationUserAccount.setActive(sourceUserAccount.isActive());
		destinationUserAccount.setCredentialsExpired(sourceUserAccount.isCredentialsExpired());
		destinationUserAccount.setUserAccountType(sourceUserAccount.getUserAccountType());

		final Collection<UserAccountUserGroup> userAccountUserRoleToPersist = new ArrayList<UserAccountUserGroup>();
		final Map<Long,UserAccountUserGroup> existingUserAccountUserGroups = new HashMap<Long,UserAccountUserGroup>();
		if(destinationUserAccount.getUserAccountUserGroups()!=null){
			for(final UserAccountUserGroup userAccountUserGroup:destinationUserAccount.getUserAccountUserGroups()){
				existingUserAccountUserGroups.put(userAccountUserGroup.getId(),userAccountUserGroup);
			}

			for(final UserAccountUserGroup newUserAccountUserGroup : sourceUserAccount.getUserAccountUserGroups()){
				if(newUserAccountUserGroup.getResourceObjectId()!=null && existingUserAccountUserGroups.containsKey(newUserAccountUserGroup.getResourceObjectId())) {
					userAccountUserRoleToPersist.add(existingUserAccountUserGroups.get(newUserAccountUserGroup.getResourceObjectId()));
				}else{
					final UserAccountUserGroup userAccountUserGroup = new UserAccountUserGroup();
					userAccountUserGroup.setUserGroupId(newUserAccountUserGroup.getUserGroupId());
					userAccountUserRoleToPersist.add(userAccountUserGroup);
				}
			}
		}
		destinationUserAccount.getUserAccountUserGroups().clear();
		destinationUserAccount.getUserAccountUserGroups().addAll(userAccountUserRoleToPersist);


		final Collection<AccessControl> accessControlToPersist = new ArrayList<AccessControl>();
		final Map<Long,AccessControl> existingAccessControls = new HashMap<Long,AccessControl>();

		if(destinationUserAccount.getAccessControls()!=null){
			for(final AccessControl accessControl:destinationUserAccount.getAccessControls()){
				existingAccessControls.put(accessControl.getId(),accessControl);
			}

			for(final AccessControl newAccessControl : sourceUserAccount.getAccessControls()){
				if(newAccessControl.getResourceObjectId()!=null && existingAccessControls.containsKey(newAccessControl.getResourceObjectId())) {
					accessControlToPersist.add(existingAccessControls.get(newAccessControl.getResourceObjectId()));
				}else{
					final AccessControl accessControl = new AccessControl();
					accessControl.setBranchId(newAccessControl.getBranchId());
					accessControlToPersist.add(accessControl);
				}
			}
		}
		destinationUserAccount.getAccessControls().clear();
		destinationUserAccount.getAccessControls().addAll(accessControlToPersist);


	}

	/**
	 * Get the Financial Year from resource.
	 *
	 * @param userAccountResource
	 * @return
	 */
	public static UserAccount getUserAccountFromResource(
			final UserAccountResource userAccountResource) {
		final UserAccount destinationUserAccount = new UserAccount();
		destinationUserAccount.setAccountExpired(userAccountResource.isAccountExpired());
		destinationUserAccount.setAccountLocked(userAccountResource.isAccountLocked());
		destinationUserAccount.setActive(userAccountResource.isActive());
		destinationUserAccount.setCredentialsExpired(userAccountResource.isCredentialsExpired());
		destinationUserAccount.setUserAccountType(userAccountResource.getUserAccountType());
		destinationUserAccount.setUsername(userAccountResource.getUsername());

		final Collection<UserAccountUserGroup> userAccountUserGroups  = new ArrayList<UserAccountUserGroup>();
		if(userAccountResource.getUserAccountUserGroups()!=null) {
			for(final UserAccountUserGroupResource userAccountUserGroupResource :userAccountResource.getUserAccountUserGroups()){
				final UserAccountUserGroup userAccountUserGroup = new UserAccountUserGroup();
				userAccountUserGroup.setUserGroupId(userAccountUserGroupResource.getUserGroup().getObjectId());
				userAccountUserGroup.setResourceObjectId(userAccountUserGroupResource.getObjectId());
				userAccountUserGroups.add(userAccountUserGroup);
			}
		}
		destinationUserAccount.setUserAccountUserGroups(userAccountUserGroups);

		final Collection<AccessControl> accessControls  = new ArrayList<AccessControl>();
		if(userAccountResource.getAccessControls()!=null) {
			for(final AccessControlResource accessControlResource :userAccountResource.getAccessControls()){
				final AccessControl accessControl = new AccessControl();
				accessControl.setBranchId(accessControlResource.getBranchId());
				accessControl.setResourceObjectId(accessControlResource.getObjectId());
				accessControls.add(accessControl);
			}
		}
		destinationUserAccount.setAccessControls(accessControls);
		return destinationUserAccount;
	}

}
