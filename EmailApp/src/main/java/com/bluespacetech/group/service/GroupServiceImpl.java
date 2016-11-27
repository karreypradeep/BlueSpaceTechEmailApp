/**
 * This document is a part of the source code and related artifacts for
 * bluespacetech.
 * www.bluespacetech.com
 * Copyright © 2016 bluespacetech
 *
 */
package com.bluespacetech.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluespacetech.core.exceptions.ApplicationException;
import com.bluespacetech.core.exceptions.BusinessException;
import com.bluespacetech.group.entity.Group;
import com.bluespacetech.group.repository.GroupRepository;
import com.bluespacetech.group.repository.GroupRepositoryCustom;
import com.bluespacetech.group.searchcriteria.GroupSearchCriteria;


/**
 * class for GroupService
 *
 * @author pradeep created date 25-June-2015
 */
@Service
@Transactional(rollbackFor = { Exception.class, RuntimeException.class, BusinessException.class,
		ApplicationException.class })
// @PreAuthorize("hasAuthority('EXCLUDE_ALL')")
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private GroupRepositoryCustom groupRepositoryCustom;

	public static void validateGroup(final Group group) throws BusinessException {
		if (group.getName() == null || group.getName().trim().length() == 0) {
			throw new BusinessException("Group Name is Mandatory.");
		}
	}

	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('CREATE_CONTACT'))")
	public Group createGroup(final Group group) throws BusinessException {
		GroupServiceImpl.validateGroup(group);
		final Group newGroup = groupRepository.save(group);
		return newGroup;
	}

	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('DELETE_CONTACT'))")
	public void deleteGroup(final Long groupId) throws BusinessException {
		groupRepository.delete(groupId);
	}

	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_GROUP'))")
	public Group getGroupById(final Long groupId) {
		final Group group = groupRepository.findOne(groupId);
		return group;
	}

	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('UPDATE_CONTACT'))")
	public Group updateGroup(final Group group) throws BusinessException {
		GroupServiceImpl.validateGroup(group);
		final Group updatedGroup = groupRepository.save(group);
		return updatedGroup;
	}

	/* (non-Javadoc)
	 * @see com.bluespacetech.group.service.GroupService#findByName(java.lang.String)
	 */
	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_GROUP'))")
	public List<Group> findByName(final String email) {
		return groupRepository.findByNameLike(email);
	}

	/* (non-Javadoc)
	 * @see com.bluespacetech.group.service.GroupService#findAll()
	 */
	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_GROUP'))")
	public List<Group> findAll() {
		return groupRepository.findAll();
	}

	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_GROUP'))")
	public List<Group> findBySearchCriteria(GroupSearchCriteria groupSearchCriteria) {
		return groupRepositoryCustom.findGroupsBySearchCriteria(groupSearchCriteria);
	}

}
