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
      title: "FULL STACK JAVA/ANGULAR WEB DEVELOPER",
      options: [
        { name: "", icon: "bi-telephone-inbound-fill", value: "+91 7972914439" },
        { name: "", icon: "bi-pin-map-fill", value: "Amravati , Maharashtra , India" },
        { name: "Mail", icon: "bi-google", href: "mailto:skcoderains@gmail.com" },
        { name: "Linkedin", icon: "bi-linkedin", href: "https://www.linkedin.com/in/mohammed-shaikh-6a9aa21b2/" },
        { name: "LeetCode", icon: "bi-code-square", href: "https://leetcode.com/coderains/" },
        { name: "CodeRains", icon: "bi-github", href: "https://github.com/SkCodeRains" },
        { name: "Portfolio", icon: "bi-award-fill", href: "https://nextleap.app/portfolio/mohammed-shaikh" },
      ]
    },
    panels: [
      {
        title: "Professional Experience",
        exps: [
          {
            role: "Full stack Software Developer | OSI Systems",
            date: {
              from: "May 2022",
              to: "Sept 2023",
              at: "Hyderabad",
              atIcon: "bi-pin-fill",
              fromIcon: "bi-calendar-check"
            },
            lists: [
              "Successfully led the migration of an AngularJS application to the latest Angular version, ensuring improved performance, responsiveness, and compatibility with modern web standards.",
              "Applied best practices to achieve a fast and responsive transition, minimizing downtime and ensuring a seamless user experience during the migration.",
              "skilled in utilizing Angular Material, Bootstrap, Element, Jasmine, and Plotly.Js.",
              `Achieved improved scalability and flexibility in the application by adopting Micro-Front-End principles, allowing for independent development and deployment of individual features.`,
              `Developed a robust Tools Management System to streamline the organization and utilization of various tools within the application.`,
              `Successfully developed Spring-Flow web apps, showcasing proficiency in dynamic component rendering for personalized widgets.`,
              `Improved efficiency by creating a centralized system for managing and updating tools, resulting in a more organized and user-friendly development environment.`,

            ]
          },
          {
            role: "Internship | OSI Systems",
            date: {
              from: "Nov 2021",
              to: "May 2022",
              at: "Hyderabad",
              atIcon: "bi-pin-fill",
              fromIcon: "bi-calendar-check"
            },
            lists: [
              "As part of CertScan® team at osi",
              "Contributed to the migration of project data-flow and transaction ",
              "Played a key role in application routing for seamless navigation and state management, contributing to the creation of a dynamic web app",
              "Strong experience developing responsive web interfaces",
            ],

          },

        ]
      },
      {
        title: "Skills / Technologies",
        adds: {
          title: "Skills / Technologies",
          data: [
            "Git", "Angular", "Java", "Spring Boot", "HTML", "SCSS", "TypeScript", "JavaScript", "Angular Material", "Spring MVC", "NgBootstrap", "Docker", "Jenkins", "Agile",
            "Spring Core", "PL-SQL", "Spring Security", "ReactJS"
          ]
        },
      },
      {
        title: "Education",
        exps: [
          /*         {
                    role: " . . Master Of Computer Application (MCA) ",
                    date: {
                      from: "Jan 2023",
                      to: "Dec 2024",
                      at: "Chandigarh University(CU)",
                      atIcon: "bi-pin-fill",
                      fromIcon: "bi-calendar-check"
                    }
                  }, */
          {
            role: " . . Bachelor Of Computer Application (BCA)",
            date: {
              from: "Nov 2015",
              to: "May 2020",
              at: "Babanrao Deshmukh College Amravati",
              atIcon: "bi-pin-fill",
              fromIcon: "bi-calendar-check"
            }
          }
        ]
      }
    ]
  }

  get headerConfig() {
    return this.pageData.headerConfig;
  }
}
