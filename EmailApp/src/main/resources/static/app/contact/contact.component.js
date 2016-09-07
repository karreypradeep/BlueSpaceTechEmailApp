"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var contact_service_1 = require("./contact.service");
var contact_1 = require("./contact");
var primeng_1 = require('primeng/primeng');
var contactgroup_1 = require("../contactgroup/contactgroup");
var group_1 = require("../group/group");
var group_service_1 = require("../group/group.service");
var common_service_1 = require("../shared/common.service");
var ContactComponent = (function () {
    function ContactComponent(contactService, groupService, commonService) {
        this.contactService = contactService;
        this.groupService = groupService;
        this.commonService = commonService;
        this.msgs = [];
        this.active = true;
    }
    ContactComponent.prototype.ngOnInit = function () {
        this.commonService.getAllGroups();
    };
    ContactComponent.prototype.onRowSelect = function (event) {
        this.contactSelected = event.data;
        this.displayViewDialog = true;
        this.updateContact = false;
    };
    ContactComponent.prototype.viewDialogCancelClick = function () {
        this.displayViewDialog = false;
    };
    ContactComponent.prototype.createContactClick = function () {
        var _this = this;
        this.contactNew = new contact_1.Contact;
        this.displayCreateDialog = true;
        this.active = false;
        setTimeout(function () { return _this.active = true; }, 0);
    };
    ContactComponent.prototype.createDialogCancelClick = function () {
        this.displayCreateDialog = false;
    };
    ContactComponent.prototype.createContactSubmit = function () {
        var _this = this;
        this.msgs = [];
        var contactGroups = [];
        if (this.contactNew.groups !== undefined) {
            for (var _i = 0, _a = this.contactNew.groups; _i < _a.length; _i++) {
                var group = _a[_i];
                var contactGroup = new contactgroup_1.ContactGroup();
                contactGroup.group = group;
                contactGroup.active = true;
                contactGroup.unSubscribed = false;
                contactGroups.push(contactGroup);
            }
            this.contactNew.contactGroups = contactGroups;
        }
        this.contactService.createContact(this.contactNew)
            .subscribe(function () {
            _this.commonService.getAllContactsBySearchCriteria();
            _this.commonService.groups = [];
            _this.displayCreateDialog = false;
            _this.msgs.push({ severity: "info", summary: "Contact created successfully.", detail: "" });
        }, function (error) {
            _this.msgs.push({ severity: "error", summary: "Contact creation failed.", detail: error });
        });
    };
    ContactComponent.prototype.updateContactClick = function () {
        this.updateContact = true;
        this.contactUpdate = this.contactSelected;
        this.contactSelected = this.cloneContact(this.contactUpdate);
        this.moreGroupItems = [];
        this.contactSelected.moreGroups = [];
        for (var _i = 0, _a = this.contactSelected.contactGroups; _i < _a.length; _i++) {
            var contactGroup = _a[_i];
            contactGroup = this.cloneContactGroup(contactGroup);
            contactGroup.group = this.cloneGroup(contactGroup.group);
        }
        for (var _b = 0, _c = this.commonService.groupItems; _b < _c.length; _b++) {
            var groupItem = _c[_b];
            var groupFound = false;
            for (var _d = 0, _e = this.contactSelected.contactGroups; _d < _e.length; _d++) {
                var contactGroup = _e[_d];
                if (contactGroup.group.name === groupItem.label) {
                    groupFound = true;
                }
            }
            if (!groupFound) {
                this.moreGroupItems.push(groupItem);
            }
        }
    };
    ContactComponent.prototype.updateContactSubmit = function () {
        var _this = this;
        this.msgs = [];
        var deleteContactGroups = [];
        for (var _i = 0, _a = this.contactSelected.contactGroups; _i < _a.length; _i++) {
            var contactGroup = _a[_i];
            if (!contactGroup.delete) {
                deleteContactGroups.push(contactGroup);
            }
        }
        this.contactSelected.contactGroups = deleteContactGroups;
        for (var _b = 0, _c = this.contactSelected.moreGroups; _b < _c.length; _b++) {
            var group = _c[_b];
            var contactGroup = new contactgroup_1.ContactGroup();
            contactGroup.group = group;
            contactGroup.active = true;
            contactGroup.unSubscribed = false;
            this.contactSelected.contactGroups.push(contactGroup);
        }
        this.contactService.updateContact(this.contactSelected)
            .subscribe(function () {
            _this.commonService.getAllContactsBySearchCriteria();
            _this.commonService.groups = [];
            _this.displayViewDialog = true;
            _this.updateContact = false;
            _this.msgs.push({ severity: "info", summary: "Contact updated successfully.", detail: "" });
        }, function (error) {
            _this.msgs.push({ severity: "error", summary: "Contact updation failed.", detail: error });
        });
    };
    ContactComponent.prototype.dialogUpdateCancelClick = function () {
        this.updateContact = false;
        this.contactSelected = this.contactUpdate;
    };
    ContactComponent.prototype.deleteSelectedContact = function () {
        var _this = this;
        this.msgs = [];
        this.contactService.deleteContact(this.contactSelected.id)
            .subscribe(function () {
            _this.commonService.getAllContactsBySearchCriteria();
            _this.commonService.groups = [];
            _this.msgs.push({ severity: "info", summary: "Contact deleted successfully.", detail: "" });
            _this.displayViewDialog = false;
        }, function (error) {
            _this.msgs.push({ severity: "error", summary: "Contact deletion failed.", detail: error });
        });
    };
    ContactComponent.prototype.cloneContact = function (cont) {
        var contact = new contact_1.Contact();
        for (var prop in cont) {
            contact[prop] = cont[prop];
        }
        return contact;
    };
    ContactComponent.prototype.cloneGroup = function (gro) {
        var group = new group_1.Group();
        for (var prop in gro) {
            group[prop] = gro[prop];
        }
        return group;
    };
    ContactComponent.prototype.cloneContactGroup = function (contGrou) {
        var contactGroup = new contactgroup_1.ContactGroup();
        for (var prop in contGrou) {
            contactGroup[prop] = contGrou[prop];
        }
        return contactGroup;
    };
    ContactComponent = __decorate([
        core_1.Component({
            selector: "my-contact",
            templateUrl: "app/contact/contact.component.html",
            styleUrls: ["app/contact/contact.component.css"],
            directives: [primeng_1.DataTable, primeng_1.Column, primeng_1.Button, primeng_1.Header, primeng_1.Footer, primeng_1.Dialog, primeng_1.MultiSelect, primeng_1.Panel, primeng_1.Growl]
        }), 
        __metadata('design:paramtypes', [contact_service_1.ContactService, group_service_1.GroupService, common_service_1.CommonService])
    ], ContactComponent);
    return ContactComponent;
}());
exports.ContactComponent = ContactComponent;
//# sourceMappingURL=..\..\contact.component.js.map