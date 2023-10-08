import { AfterViewInit, Component, OnInit } from '@angular/core';
import * as JSZip from 'jszip';
import { saveAs, encodeBase64 } from '@progress/kendo-file-saver';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, AfterViewInit {

  name!: string;


  iteration = 1

  constructor() { }
  ngAfterViewInit(): void {
    this.name = "aman"
  }
  ngOnInit(): void {
    const jszip = new JSZip();
    let int = setInterval(() => {
      if (this.iteration > 205) {
        console.log(jszip);
        jszip.generateAsync({ type: 'blob' }).then(function (content) {
          // see FileSaver.js
          saveAs(content, 'example.zip');
        });
        clearInterval(int)
      }
      this.getImage(this.iteration).then((file: File) => {
        var reader = new FileReader();
        reader.readAsDataURL(file);
        let result: any;
        reader.onloadend = () => {
          result = reader.result;
          this.files.push({ url: result, name: file.name, file: file });
          /*   const a: any = document.createElement('a');
            a.href = result;
            // a.download = 'algorithms' + iteration + '.jpeg';
            a.download = file.name;
            document.body.appendChild(a);
            a.style = 'display: none';
            a.click();
            a.remove(); */
        };
        jszip.file(file.name, file);
      });
      this.iteration++;
    }, 100);
  }
  title = 'my-first-app';
  files: Array<{ url: string, name: string, file: File }> = []
  async getImage(fileName: any) {
    // on the first then you will return blob from response https://online.pubhtml5.com/kcvf/btgt/files/large/8.jpg?1618508139
    //https://online.pubhtml5.com/kcvf/vdxq/files/large/6.jpg?1618504100
    return await fetch('https://online.pubhtml5.com/kcvf/lmcx/files/large/' + fileName + '.jpg?1603459289').then(r => r.blob())
      .then((blob) => { // on the second, you just create a file from that blob, getting the type and name that intend to inform

        return new File([blob], fileName + '.' + blob.type.split('/')[1]);
      });
  }

}
