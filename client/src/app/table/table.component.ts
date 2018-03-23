import { Component, OnInit,Input  } from '@angular/core';
import { NgIf } from '@angular/common';
import { TableService } from '../shared';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
  providers: [TableService]
})
export class TableComponent implements OnInit {

  cells: Array<any>;
  grid: Object;

  constructor(private tableService: TableService) { }


  @Input() className: string;
  @Input() type: string;

  refreshClick(event: any, heightValue : number, widthValue : number ) {
   this.tableService.getAll(  widthValue, heightValue ).subscribe(
    data => {
      this.grid = data;
      this.cells = data.gridList;
    },
    error => console.log(error)

    )
  }

  switchCell( c : any ) {
    console.log("celll");
    console.log(c);

    this.cells.forEach( existingCellRow => {
      existingCellRow.forEach( existingCell => {
        if(existingCell.gridReference.x == c.gridReference.x && existingCell.gridReference.y == c.gridReference.y ) {
          c.cellstate = 'LIVE';
        }
      });
    } );


  }


  tickClick(event: any) {
    console.log("this is a test");
      console.log(this.grid);

    this.tableService.tick(this.grid).subscribe(
    data => {
      this.grid = data;

      this.cells = data.gridList;
      console.log(this.cells);
    },
    error => console.log(error)
    )
  }


  ngOnInit() {
    this.tableService.getAll(40, 40 ).subscribe(
data => {
console.log(data.constructor.name);
console.log(data);
      this.grid = data;
      this.cells = data.gridList;
      console.log(this.cells);
    },
    error => console.log(error)
)
}

}
