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
var primeng_1 = require('primeng/primeng');
var group_service_1 = require("./group.service");
var group_1 = require("./group");
var common_service_1 = require("../shared/common.service");
var GroupComponent = (function () {
    function GroupComponent(groupService, commonService) {
        this.groupService = groupService;
        this.commonService = commonService;
        this.msgs = [];
        this.active = true;
    }
    GroupComponent.prototype.onRowSelect = function (event) {
        this.displayViewDialog = true;
        this.groupSelected = event.data;
        this.updateGroup = false;
    };
    GroupComponent.prototype.viewDialogCancelClick = function () {
        this.displayViewDialog = false;
    };
    GroupComponent.prototype.createGroupClick = function () {
        var _this = this;
        this.groupNew = new group_1.Group();
        this.displayCreateDialog = true;
        this.active = false;
        setTimeout(function () { return _this.active = true; }, 0);
    };
    GroupComponent.prototype.createDialogCancelClick = function () {
        this.displayCreateDialog = false;
    };
    GroupComponent.prototype.createGroupSubmit = function () {
        var _this = this;
        this.msgs = [];
        this.groupService.createGroup(this.groupNew)
            .subscribe(function () {
            _this.commonService.searchGroupsByCriteria();
            _this.displayCreateDialog = false;
            _this.commonService.getAllGroups();
            _this.commonService.contacts = [];
            _this.msgs.push({ severity: "info", summary: "Group created successfully.", detail: "" });
        }, function (error) {
            _this.msgs.push({ severity: "error", summary: "Group creation failed.", detail: error });
        });
    };
    GroupComponent.prototype.updateGroupClick = function () {
        this.updateGroup = true;
        this.groupUpdate = this.groupSelected;
        this.groupSelected = this.cloneGroup(this.groupUpdate);
    };
    GroupComponent.prototype.deleteSelectedGroup = function () {
        var _this = this;
        this.msgs = [];
        this.groupService.deleteGroup(this.groupSelected.id)
            .subscribe(function () {
            _this.commonService.searchGroupsByCriteria();
            _this.msgs.push({ severity: "info", summary: "Group deleted successfully.", detail: "" });
            _this.displayViewDialog = false;
            _this.commonService.contacts = [];
        }, function (error) {
            _this.msgs.push({ severity: "error", summary: "Group deletion failed.", detail: error });
        });
    };
    GroupComponent.prototype.updateGroupSubmit = function () {
        var _this = this;
        this.msgs = [];
        this.groupService.updateGroup(this.groupSelected)
            .subscribe(function () {
            _this.commonService.searchGroupsByCriteria();
            _this.displayViewDialog = true;
            _this.updateGroup = false;
            _this.commonService.contacts = [];
            _this.msgs.push({ severity: "info", summary: "Group updated successfully.", detail: "" });
        }, function (error) {
            _this.msgs.push({ severity: "error", summary: "Group updation failed.", detail: error });
        });
    };
    GroupComponent.prototype.dialogUpdateCancelClick = function () {
        this.updateGroup = false;
        this.groupSelected = this.groupUpdate;
    };
    GroupComponent.prototype.cloneGroup = function (gro) {
        var group = new group_1.Group();
        for (var prop in gro) {
            group[prop] = gro[prop];
        }
        return group;
    };
    GroupComponent = __decorate([
        core_1.Component({
            selector: "my-group",
            templateUrl: "app/group/group.component.html",
            directives: [primeng_1.DataTable, primeng_1.Column, primeng_1.Growl]
        }), 
        __metadata('design:paramtypes', [group_service_1.GroupService, common_service_1.CommonService])
    ], GroupComponent);
    return GroupComponent;
}());
exports.GroupComponent = GroupComponent;
//# sourceMappingURL=..\..\group.component.js.map