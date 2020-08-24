import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { Company } from 'src/app/interfaces/company';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.scss']
})
export class CompanyComponent implements OnInit {
  companies$: Observable<Company[]>;

  constructor(private service: CompanyService) { }

  ngOnInit() {
  }

  getCompanies() {
    this.companies$ = this.service.get('companies');
  }

}
