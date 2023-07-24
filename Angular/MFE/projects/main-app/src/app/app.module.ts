import { LazyElementsModule } from '@angular-extensions/elements';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import "dist/mfe-1/main.js";
import "dist/mfe-1/polyfills.js";
import "dist/mfe-1/runtime.js";
import "dist/mfe-2/main.js";
import "dist/mfe-2/polyfills.js";
import "dist/mfe-2/runtime.js";

import { AppComponent } from './app.component';
import { BasicHightlightDirective } from './directories/basic-highlight.directive';
import { BetterHightlightDirective } from './directories/better-highlist.directive';

@NgModule({
  declarations: [
    AppComponent,
    BasicHightlightDirective,
    BetterHightlightDirective
  ],
  imports: [
    BrowserModule,
    LazyElementsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
