import { Component, ViewEncapsulation } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { InstaPageComponent } from './components/body/insta-page/insta-page.component';
import { HttpClientModule } from '@angular/common/http';
import { RestHelperService } from './rest-helper.service';
import { UserService } from './services/user-service.service';
import { LoginComponent } from './components/body/login/login.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, InstaPageComponent, HttpClientModule,LoginComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  encapsulation: ViewEncapsulation.ShadowDom,
  providers: [RestHelperService, UserService]
})
export class AppComponent {
  title = 'insta-clone-ui-ssr';
}
