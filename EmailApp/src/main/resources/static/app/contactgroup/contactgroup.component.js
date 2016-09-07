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
var contactgroup_service_1 = require("./contactgroup.service");
var ContactGroupComponent = (function () {
    function ContactGroupComponent(contactGroupService) {
        this.contactGroupService = contactGroupService;
    }
    ContactGroupComponent.prototype.ngOnInit = function () {
        this.getAllContactGroups();
    };
    ContactGroupComponent.prototype.getAllContactGroups = function () {
        var _this = this;
        this.contactGroupService.getAllContactGroups()
            .subscribe(function (contactGroups) { return _this.contactGroups = contactGroups; }, function (error) { return _this.errorMessage = error; });
    };
    ContactGroupComponent = __decorate([
        core_1.Component({
            templateUrl: "app/contactgroup/contactgroup.component.html"
        }), 
        __metadata('design:paramtypes', [contactgroup_service_1.ContactGroupService])
    ], ContactGroupComponent);
    return ContactGroupComponent;
}());
exports.ContactGroupComponent = ContactGroupComponent;
//# sourceMappingURL=..\..\contactgroup.component.js.map