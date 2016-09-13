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
var router_1 = require("@angular/router");
var http_1 = require('@angular/http');
var contact_service_1 = require("./contact/contact.service");
var group_service_1 = require("./group/group.service");
var contactgroup_service_1 = require("./contactgroup/contactgroup.service");
var common_service_1 = require("../app/shared/common.service");
var email_service_1 = require("../app/email/email.service");
require('./rxjs-operators');
var AppComponent = (function () {
    function AppComponent() {
        this.title = "Mass Mailing Application";
    }
    AppComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: "app-root",
            templateUrl: "app.component.html",
            styleUrls: ["app.component.css"],
            directives: [router_1.ROUTER_DIRECTIVES],
            providers: [http_1.HTTP_PROVIDERS, contact_service_1.ContactService, group_service_1.GroupService, contactgroup_service_1.ContactGroupService, common_service_1.CommonService, email_service_1.EmailService]
        }), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=..\app.component.js.map