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
var http_1 = require("@angular/http");
var Observable_1 = require("rxjs/Observable");
var EmailServerService = (function () {
    function EmailServerService(http) {
        this.http = http;
        this.emailServerURL = "http://localhost:8080/emailServer";
    }
    EmailServerService.prototype.getAllEmailServers = function () {
        return this.http.get(this.emailServerURL)
            .map(function (res) { return res.json(); })
            .catch(this.handleError);
    };
    EmailServerService.prototype.deleteEmailServer = function (objectId) {
        return this.http.delete(this.emailServerURL + "/" + objectId)
            .map(function (res) { return; })
            .catch(this.handleError);
    };
    EmailServerService.prototype.updateEmailServerSubmit = function (emailServer) {
        var headers = new http_1.Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.put(this.emailServerURL + "/" + emailServer.id, JSON.stringify(emailServer), { headers: headers })
            .map(function (res) { return res.json(); })
            .catch(this.handleError);
    };
    EmailServerService.prototype.extractData = function (res) {
        var body = res.json();
        return body || {};
    };
    EmailServerService.prototype.handleError = function (error) {
        var errMsg = (error.message) ? error.message :
            error.status ? error.status + " - " + error.statusText : 'Server error';
        console.error(errMsg);
        return Observable_1.Observable.throw(errMsg);
    };
    EmailServerService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], EmailServerService);
    return EmailServerService;
}());
exports.EmailServerService = EmailServerService;
//# sourceMappingURL=..\..\emailserver.service.js.map