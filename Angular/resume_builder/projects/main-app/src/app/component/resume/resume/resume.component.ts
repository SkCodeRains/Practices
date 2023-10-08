import { Component } from '@angular/core';

@Component({
  selector: 'app-resume',
  templateUrl: './resume.component.html',
  styleUrls: ['./resume.component.scss']
})
export class ResumeComponent {
  /* 
  
  I was a part of S2 Global ( OSI Systems) team and responsible for building highly reliable and scalable features within Angular UI Application with micro services and REST API based infrastructure.
  Designed reusable and reliable code for use within distributed cloud environments.
  Documented technical workflows and knowledge to educate  colleague  and newly hired employees.
  Designed intuitive graphical user interfaces to improve user experience.
  Discussed issues with team members to provide resolution and apply best practices.
  
  */

  pageData: any = {
    headerConfig: {
      name: "Mohammed Shaikh",
      title: "FULLSTACK JAVA/ANGULAR WEB DEVELOPER",
      options: [
        { name: "", icon: "bi-phone", value: "+91 7972914439" },
        { name: "Mail", icon: "bi-google", href: "mailto:skcoderains@gmail.com" },
        { name: "", icon: "bi-pin", value: "Amravati Maharashtra" },
        { name: "Linkedin", icon: "bi-linkedin", href: "https://www.linkedin.com/in/mohammed-shaikh-6a9aa21b2/" },
        { name: "LeetCode", icon: "bi-code-square", href: "https://leetcode.com/coderains/" },
        { name: "CodeRains", icon: "bi-github", href: "https://github.com/SkCodeRains" },
      ]
    }
  }

  get headerConfig() {
    return this.pageData.headerConfig;
  }
}
