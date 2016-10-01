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
var contact_component_1 = require("../contact/contact.component");
var group_component_1 = require("../group/group.component");
var dashboard_content_component_1 = require("../dashboard/dashboard_content.component");
var email_component_1 = require("../email/email.component");
var primeng_1 = require("primeng/primeng");
var emailserver_component_1 = require("../emailserver/emailserver.component");
var DashboardComponent = (function () {
    function DashboardComponent() {
        this.title = "Mass Mailing Application";
        this.sideMenuSeleted = "dashboard";
    }
    DashboardComponent.prototype.sideMenuClick = function (index) {
        if (index == 1) {
            this.sideMenuSeleted = "dashboard";
        }
        else if (index == 2) {
            this.sideMenuSeleted = "emails";
        }
        else if (index == 3) {
            this.sideMenuSeleted = "contacts";
        }
        else if (index == 4) {
            this.sideMenuSeleted = "groups";
        }
        else if (index == 5) {
            this.sideMenuSeleted = "reports";
        }
        else if (index == 6) {
            this.sideMenuSeleted = "servers";
        }
    };
    DashboardComponent = __decorate([
        core_1.Component({
            templateUrl: "./app/dashboard/dashboard.component.html",
            directives: [primeng_1.TabView, primeng_1.TabPanel, primeng_1.Panel, contact_component_1.ContactComponent, group_component_1.GroupComponent, dashboard_content_component_1.DashboardContentComponent, email_component_1.EmailComponent, emailserver_component_1.EmailServerComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], DashboardComponent);
    return DashboardComponent;
}());
exports.DashboardComponent = DashboardComponent;
//# sourceMappingURL=..\..\dashboard.component.js.map