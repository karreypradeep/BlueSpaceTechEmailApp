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
var primeng_1 = require("primeng/primeng");
var emailserver_1 = require("./emailserver");
var emailserver_service_1 = require("./emailserver.service");
var emailserver_properties_1 = require("./emailserver.properties");
var EmailServerComponent = (function () {
    function EmailServerComponent(emailServerService) {
        this.emailServerService = emailServerService;
        this.msgs = [];
        this.emailServers = [];
        this.active = true;
    }
    EmailServerComponent.prototype.ngOnInit = function () {
        this.getAllEmailServers();
        this.loadEmailServerPropertyType();
    };
    EmailServerComponent.prototype.loadEmailServerPropertyType = function () {
        this.emailServerPropertyTypes = [];
        this.emailServerPropertyTypes.push({ label: 'String', value: 1 /* string */ });
        this.emailServerPropertyTypes.push({ label: 'Number', value: 0 /* number */ });
        this.emailServerPropertyTypes.push({ label: 'Boolean', value: 2 /* boolean */ });
    };
    EmailServerComponent.prototype.onRowSelect = function (event) {
        this.emailServerSelected = event.data;
        this.viewEmailServer = true;
    };
    EmailServerComponent.prototype.getAllEmailServers = function () {
        var _this = this;
        this.emailServerService.getAllEmailServers()
            .subscribe(function (emailServers) {
            _this.emailServers = emailServers;
        });
    };
    EmailServerComponent.prototype.updateEmailServerSubmit = function () {
        var _this = this;
        this.emailServerService.updateEmailServerSubmit(this.emailServerSelected)
            .subscribe(function (emailServerUpdated) {
            _this.emailServerSelected = emailServerUpdated;
            _this.viewEmailServer = true;
            _this.updateEmailServer = false;
            _this.msgs.push({ severity: "info", summary: "Email Server updated successfully.", detail: "" });
        }, function (error) {
            _this.msgs.push({ severity: "error", summary: "Email Server updation failed.", detail: error });
        });
    };
    EmailServerComponent.prototype.createEmailServerClick = function () {
        var _this = this;
        this.emailServerNew = new emailserver_1.EmailServer();
        this.emailServerPropertyNew = new emailserver_properties_1.EmailServerProperty();
        this.createEmailServer = true;
        this.active = false;
        setTimeout(function () { return _this.active = true; }, 0);
    };
    EmailServerComponent.prototype.addEmailServerPropertyClick = function () {
    };
    EmailServerComponent.prototype.createEmailServerCancleClick = function () {
        this.createEmailServer = false;
        this.updateEmailServer = false;
    };
    EmailServerComponent.prototype.viewEmailServerCancleClick = function () {
        this.viewEmailServer = false;
        this.updateEmailServer = false;
    };
    EmailServerComponent.prototype.updateEmailServerClick = function () {
        this.updateEmailServer = true;
        this.viewEmailServer = true;
        this.emailServerUpdate = this.emailServerSelected;
        this.emailServerSelected = this.cloneContact(this.emailServerUpdate);
    };
    EmailServerComponent.prototype.updateEmailServerCancel = function () {
        this.updateEmailServer = false;
        this.viewEmailServer = true;
    };
    EmailServerComponent.prototype.cloneContact = function (server) {
        var emailServer = new emailserver_1.EmailServer();
        for (var prop in server) {
            emailServer[prop] = server[prop];
        }
        return emailServer;
    };
    EmailServerComponent.prototype.deleteEmailServerCancleClick = function () {
        var _this = this;
        this.msgs = [];
        this.emailServerService.deleteEmailServer(this.emailServerSelected.id)
            .subscribe(function () {
            _this.msgs.push({ severity: "info", summary: "Email Server deleted successfully.", detail: "" });
            _this.viewEmailServer = false;
            _this.getAllEmailServers();
        }, function (error) {
            _this.msgs.push({ severity: "error", summary: "Email Server deletion failed.", detail: error });
        });
    };
    EmailServerComponent = __decorate([
        core_1.Component({
            selector: "my-servers",
            templateUrl: "app/emailserver/emailserver.component.html",
            directives: [primeng_1.Growl, primeng_1.DataTable, primeng_1.Column, primeng_1.Button, primeng_1.Header, primeng_1.Footer, primeng_1.Dropdown, primeng_1.Listbox]
        }), 
        __metadata('design:paramtypes', [emailserver_service_1.EmailServerService])
    ], EmailServerComponent);
    return EmailServerComponent;
}());
exports.EmailServerComponent = EmailServerComponent;
//# sourceMappingURL=..\..\emailserver.component.js.map