import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { CreateCharacterComponent } from './create-character/create-character.component';

import {StoryCharacterService} from "./service/story-character.service";
import {appRoutes} from "./app.routes";
import { FindAllCharacterComponent } from './find-all-character/find-all-character.component';
import { ImportCharacterComponent } from './import-character/import-character.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateCharacterComponent,
    FindAllCharacterComponent,
    ImportCharacterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [StoryCharacterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
