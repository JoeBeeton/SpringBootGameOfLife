import { Component, Injectable,Input,Output,EventEmitter } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TableService {

constructor(private http: HttpClient) {}

  getAll(xValue: number, yValue: number): Observable<any> {
    console.log("ingetAll");

    console.log(xValue);
    console.log(yValue);
    const reqOpts = {
      params: new HttpParams()
        .set( 'Content-Type',  'application/json')
        .set( 'xLength',  xValue.toString())
        .set( 'yLength', yValue.toString())

    };


console.log(reqOpts);
    return this.http.get('http://localhost:8080/newGrid',reqOpts);
  }

  tick(cells: Object): Observable<any> {
    console.log(cells);
    return this.http.post('http://localhost:8080/tick', cells);
  }


}

