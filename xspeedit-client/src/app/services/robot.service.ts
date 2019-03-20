import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RobotService {
  private baseUrl: String = '//localhost:8080/robot/';

  constructor(private http: HttpClient) {
  }

  getOpimized(chaineArticle: string): Observable<any> {
    return this.http.get(this.baseUrl + 'optimized/' + chaineArticle);
  }

  getActual(chaineArticle: string): Observable<any> {
    return this.http.get(this.baseUrl + 'actual/' + chaineArticle);
  }
}
