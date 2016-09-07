"use strict";
var router_1 = require("@angular/router");
var dashboard_component_1 = require("./dashboard/dashboard.component");
var contact_component_1 = require("./contact/contact.component");
var group_component_1 = require("./group/group.component");
var routes = [
    {
        path: "",
        redirectTo: "/dashboard"
    },
    {
        path: "dashboard",
        component: dashboard_component_1.DashboardComponent
    },
    {
        path: "contacts",
        component: contact_component_1.ContactComponent
    },
    {
        path: "groups",
        component: group_component_1.GroupComponent
    }
];
exports.appRouterProviders = [
    router_1.provideRouter(routes)
];
//# sourceMappingURL=..\app.routes.js.map