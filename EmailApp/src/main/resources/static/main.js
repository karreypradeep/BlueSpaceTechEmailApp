"use strict";
var platform_browser_dynamic_1 = require("@angular/platform-browser-dynamic");
var core_1 = require("@angular/core");
var _1 = require("./app/");
var app_module_1 = require("./app/app.module");
var forms_1 = require('@angular/forms');
var app_routes_1 = require("./app/app.routes");
if (_1.environment.production) {
    core_1.enableProdMode();
}
platform_browser_dynamic_1.bootstrap(_1.AppComponent, [app_module_1.AppModule, app_routes_1.appRouterProviders, forms_1.disableDeprecatedForms(), forms_1.provideForms()]);
//# sourceMappingURL=main.js.map