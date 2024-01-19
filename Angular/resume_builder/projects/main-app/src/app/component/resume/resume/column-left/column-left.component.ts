import { Component } from '@angular/core';

@Component({
  selector: 'app-column-left',
  templateUrl: './column-left.component.html',
  styleUrls: ['./column-left.component.scss']
})
export class ColumnLeftComponent {

  private code = 'Template <script>alert(45); let a = 45;alert(25)<b>Syntax</b> </script>'


  data: any = [{
    title: "Achievements",
    options: [
      {
        class: "bi-award-fill",
        text: "Successfully executed seamless migrations from AngularJS to the latest Angular version, and from a monolithic JavaScript application to a Micro-Front-End architecture."
      },
      {
        class: "bi-award-fill",
        text: "Recognized for designing and implementing robust User Configuration and Management Systems, as well as Tools Management Systems."
      },
      {
        class: "bi-award-fill",
        text: "Implemented an Application Flow Transaction Control System, ensuring the integrity and reliability of application transactions."
      },
      {
        class: "bi-award-fill",
        text: "Received positive feedback for the development of a responsive full-width auto-adjust carousel, contributing to an improved user interface. "
      },
      {
        class: "bi-award-fill",
        text: "Researched on the springFlo angular open source app and build latest updated advanced featured library"
      }

    ]
  },
  {
    title: "Strength",
    options: [
      {
        class: "bi-boxes",
        text: "Possess Great Analytical And Problem Solving Skills"
      },
      {
        class: "bi-microsoft-teams",
        text: "Teams Powers Positive thinking & Self-Motivation"

      }, {
        class: "bi-radar",
        text: "Fast Adaptability to situations"
      }
    ]
  },

  /*     {
        title: "AWARDS",
        options: [
          {
            class: "bi-star-fill",
            text: "Awarded as \" Best Coder Award \" at OSI Systems"
          },
          {
            class: "bi-star-fill",
            text: "Awarded as \" Goes Above And Beyond \" at OSI Systems"
  
          }
        ]
      }, */
  {
    title: "certificates",
    options: [
      {
        head: "Udemy",
        text: "Full-Stack java Spring-boot + React/Angular"
      },
      {
        head: "NEXT-Leap",
        text: "Data Structure And Algorithms with java"

      }
    ]
  },
  {
    title: "Projects",
    options: [
      {
        head: "Instagram clone",
        text: `Web application using angular spring-boot `
      },
      {
        head: "Library management",
        text: `Desktop Application ,To Manage the Books of Library and issue and return
          Functionality`
      }
    ]
  },

  ]


}
