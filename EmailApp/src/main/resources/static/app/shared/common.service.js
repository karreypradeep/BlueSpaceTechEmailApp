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
var contact_service_1 = require("../contact/contact.service");
var group_service_1 = require("../group/group.service");
var contact_search_criteria_1 = require("../contact/contact_search_criteria");
var group_search_criteria_1 = require("../group/group_search_criteria");
var CommonService = (function () {
    function CommonService(contactService, groupService) {
        this.contactService = contactService;
        this.groupService = groupService;
        this.contactSearchCriteria = new contact_search_criteria_1.ContactSearchCriteria();
        this.groupSearchCriteria = new group_search_criteria_1.GroupSearchCriteria();
    }
    CommonService.prototype.getAllContacts = function () {
        var _this = this;
        this.contactService.getAllContacts()
            .subscribe(function (contacts) {
            _this.contacts = contacts;
            for (var _i = 0, _a = _this.contacts; _i < _a.length; _i++) {
                var contact = _a[_i];
                for (var _b = 0, _c = contact.contactGroups; _b < _c.length; _b++) {
                    var contactGroup = _c[_b];
                    if (contact.groupDetails === undefined) {
                        contact.groupDetails = contactGroup.group.name;
                    }
                    else {
                        contact.groupDetails += ", " + contactGroup.group.name;
                    }
                }
            }
        });
    };
    CommonService.prototype.getAllContactsBySearchCriteria = function () {
        var _this = this;
        this.contactService.getAllContactsByCriteria(this.contactSearchCriteria)
            .subscribe(function (contacts) {
            _this.contacts = contacts;
            for (var _i = 0, _a = _this.contacts; _i < _a.length; _i++) {
                var contact = _a[_i];
                for (var _b = 0, _c = contact.contactGroups; _b < _c.length; _b++) {
                    var contactGroup = _c[_b];
                    if (contact.groupDetails === undefined) {
                        contact.groupDetails = contactGroup.group.name;
                    }
                    else {
                        contact.groupDetails += ", " + contactGroup.group.name;
                    }
                }
            }
        });
    };
    CommonService.prototype.getAllGroups = function () {
        var _this = this;
        this.groupService.getAllGroups()
            .subscribe(function (groups) {
            _this.groupItems = [];
            _this.groupNamesForSearch = [];
            for (var _i = 0, groups_1 = groups; _i < groups_1.length; _i++) {
                var group = groups_1[_i];
                _this.groupItems.push({ label: group.name, value: group });
                _this.groupNamesForSearch.push({ label: group.name, value: group.name });
            }
        });
    };
    CommonService.prototype.searchGroupsByCriteria = function () {
        var _this = this;
        this.groupService.getAllGroupsBySearchCriteria(this.groupSearchCriteria)
            .subscribe(function (groups) { return _this.groups = groups; });
    };
    CommonService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [contact_service_1.ContactService, group_service_1.GroupService])
    ], CommonService);
    return CommonService;
}());
exports.CommonService = CommonService;
//# sourceMappingURL=..\..\common.service.js.map