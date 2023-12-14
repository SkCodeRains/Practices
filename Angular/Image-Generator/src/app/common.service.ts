import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonService {


  constructor(private http: HttpClient) { }

  GenerateImage(search: string, size: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer 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'
    });
    let data: any = {
      "model": "dall-e-2",
      "prompt": search,
      "n": size,
      "size": "1024x1024",
      "response_format": "b64_json"
    };
    return this.http.post('https://api.openai.com/v1/images/generations', data, { headers });
  }
}
