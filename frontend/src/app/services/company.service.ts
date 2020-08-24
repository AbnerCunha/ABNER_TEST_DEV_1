import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Company } from '../interfaces/company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  private readonly url = 'http://localhost:4200/api/';

  constructor(private http: HttpClient) { }

  get(endpoint: string) {
    return this.http.get<Company[]>(this.url + endpoint);
  }
}
