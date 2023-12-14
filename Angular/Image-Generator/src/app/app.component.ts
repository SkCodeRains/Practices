import { Component } from '@angular/core';
import { CommonService } from './common.service';
declare var $: any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Image-Generator';
  image: any;
  listOfImages: any[] = [
    {
      url: "assets/images/img-4.jpg"
    }, {
      url: "assets/images/img-5.jpg"
    }, {
      url: "assets/images/img-6.jpg"
    },
    {
      url: "assets/images/img-7.jpg"
    }

  ];
  isImageGenerating: boolean = false;
  constructor(private serv: CommonService) { }

  generateImage(inputBox: HTMLInputElement, imgSize: any) {
    var Search = inputBox.value.trim();
    if (Search.length > 0) {
      imgSize = parseInt(imgSize);
      this.isImageGenerating = true;
      let backup = this.listOfImages;
      this.listOfImages = [];
      for (let index = 0; index < imgSize; index++) {
        this.listOfImages.push({ url: "assets/images/loader.svg" });
      }
      // debugger
      this.serv.GenerateImage(Search, imgSize).subscribe({
        next: response => {
          this.listOfImages = response.data.map((item: any) => {
            item.url = `data:image/jpeg;base64,${item.b64_json}`;
            return item;
          });
        },
        error: () => {
          this.listOfImages = backup;
          alert("Failed to generate AI images. Make sure your API key is valid.");
        }
      }).add(() => {
        this.isImageGenerating = false;
      });
    } else {
      alert("Pelase specify prompt");
    }

  }
}
function handleHttpError(error: any) {
  throw new Error('Function not implemented.');
}

