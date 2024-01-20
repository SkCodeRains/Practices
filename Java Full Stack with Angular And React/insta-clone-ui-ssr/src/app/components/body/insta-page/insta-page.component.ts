import { Component, ViewEncapsulation } from '@angular/core';
import { MobileFootComponent } from '../mobile-foot/mobile-foot.component';
import { MobileHeadComponent } from '../mobile-head/mobile-head.component';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-insta-page',
  standalone: true,
  imports: [MobileFootComponent, MobileHeadComponent, LoginComponent],
  templateUrl: './insta-page.component.html',
  styleUrl: './insta-page.component.scss',
})
export class InstaPageComponent {

}
