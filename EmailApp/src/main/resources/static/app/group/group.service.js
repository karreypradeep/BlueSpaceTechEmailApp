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
require('rxjs/add/operator/catch');
require('rxjs/add/operator/map');
var GroupService = (function () {
    function GroupService(http) {
        this.http = http;
        this.groupUrl = "/groups";
    }
    GroupService.prototype.getAllGroups = function () {
        return this.http.get(this.groupUrl)
            .map(function (res) { return res.json(); })
            .catch(this.handleError);
    };
    GroupService.prototype.getAllGroupsBySearchCriteria = function (groupSearchCriteria) {
        var headers = new http_1.Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this.groupUrl + "/searchCriteria", JSON.stringify(groupSearchCriteria), { headers: headers })
            .map(function (res) { return res.json(); })
            .catch(this.handleError);
    };
    GroupService.prototype.createGroup = function (group) {
        var headers = new http_1.Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this.groupUrl, JSON.stringify(group), { headers: headers })
            .map(function (res) { return; })
            .catch(this.handleError);
    };
    GroupService.prototype.updateGroup = function (group) {
        var headers = new http_1.Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.put(this.groupUrl + "/" + group.id, JSON.stringify(group), { headers: headers })
            .map(function (res) { return; })
            .catch(this.handleError);
    };
    GroupService.prototype.deleteGroup = function (objectId) {
        return this.http.delete(this.groupUrl + "/" + objectId)
            .map(function (res) { return; })
            .catch(this.handleError);
    };
    GroupService.prototype.handleError = function (error) {
        var errMsg = (error.message) ? error.message :
            error.status ? error.status + " - " + error.statusText : 'Server error';
        console.error(errMsg);
        return Observable_1.Observable.throw(errMsg);
    };
    GroupService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], GroupService);
    return GroupService;
}());
exports.GroupService = GroupService;
//# sourceMappingURL=..\..\group.service.js.map