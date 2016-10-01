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
var email_1 = require("./email");
var common_service_1 = require("../shared/common.service");
var email_service_1 = require("./email.service");
var EmailComponent = (function () {
    function EmailComponent(emailService, commonService) {
        this.emailService = emailService;
        this.commonService = commonService;
        this.emailVO = new email_1.Email();
        this.active = true;
        this.selectedGroups = [];
        this.msgs = [];
        this.emailSending = false;
    }
    EmailComponent.prototype.ngOnInit = function () {
        this.commonService.getAllGroups();
    };
    EmailComponent.prototype.sendEmail = function () {
        var _this = this;
        this.emailVO.groupIdList = [];
        for (var _i = 0, _a = this.selectedGroups; _i < _a.length; _i++) {
            var group = _a[_i];
            this.emailVO.groupIdList.push(group.id);
        }
        this.emailService.sendEmail(this.emailVO)
            .subscribe(function () {
            _this.emailVO = new email_1.Email();
            _this.selectedGroups = [];
            _this.active = false;
            setTimeout(function () { return _this.active = true; }, 0);
            _this.msgs.push({ severity: "info", summary: "Email sent successfully.", detail: "" });
            _this.emailSending = false;
        }, function (error) {
            _this.msgs.push({ severity: "error", summary: "Email sending failed.", detail: error });
            _this.emailSending = false;
        });
    };
    EmailComponent.prototype.showDialog = function () {
        this.emailSending = true;
    };
    EmailComponent.prototype.cancelClick = function () {
        this.emailVO = new email_1.Email();
    };
    EmailComponent = __decorate([
        core_1.Component({
            selector: "my-email",
            templateUrl: "app/email/email.component.html",
            directives: [primeng_1.Growl, primeng_1.Dialog, primeng_1.ProgressBar]
        }), 
        __metadata('design:paramtypes', [email_service_1.EmailService, common_service_1.CommonService])
    ], EmailComponent);
    return EmailComponent;
}());
exports.EmailComponent = EmailComponent;
//# sourceMappingURL=..\..\email.component.js.map