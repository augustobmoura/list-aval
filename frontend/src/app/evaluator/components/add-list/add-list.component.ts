import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { ModalComponent } from 'src/app/shared/components/modal/modal.component';
import { listModel } from 'src/app/student/components/my-list/my-list.component';


@Component({
  selector: 'app-add-list',
  templateUrl: './add-list.component.html',
  styleUrls: ['./add-list.component.scss']
})
export class AddListComponent implements OnInit {

  lists: listModel[] = [];
  p = 1;
  selectedList: number = null;
  selectListName = '';

  evaluatorForm: FormGroup;

  evaluatorGroups: any[] = [{
    id: '1',
    name: 'Carlos Alberto'
  },
    {
      id: '2',
      name: 'Maria Julia'
    },
    {
      id: '3',
      name: 'Carla Maria'
    },
    {
      id: '4',
      name: 'João Antônio'
    },
    {
      id: '5',
      name: 'Pablo Almeida'
    }];

  filteredOptions$: Observable<any[]>;

  @ViewChild('modalAddEvaluator', { static: true }) modalAddEvaluator: ModalComponent;

  constructor(private fb: FormBuilder) {
    this.evaluatorForm = fb.group({
      evaluator: ['']
    });
  }

  ngOnInit() {
    for (let i = 0; i < 25; i++) {
      this.lists.push({
        title: `Engenharia de Software ${i}`,
        class: `Turma ${i}`,
        date: new Date(2019, 10, 15),
        id: i,
        publicado: i % 2 === 0 ? true : false
      });
    }

    this.filteredOptions$ = this.evaluatorForm.get('evaluator').valueChanges
      .pipe(
        startWith(''),
        map(value => typeof value === 'string' ? value : value.name),
        map(name => name ? this._filter(name) : this.evaluatorGroups.slice())
      );
  }

  displayFn(user?: any): string | undefined {
    return user ? user.name : undefined;
  }

  private _filter(name: string): any[] {
    const filterValue = name.toLowerCase();
    return this.evaluatorGroups.filter(option => option.name.toLowerCase().indexOf(filterValue) === 0);
  }

  openModal(listID, listTitle) {
    this.selectedList = listID;
    this.selectListName = listTitle;
    this.modalAddEvaluator.open();
  }

  pageChanged($event) {
    this.p = $event;
  }

  onSubmit() {
    console.log(this.evaluatorForm.value);
    this.modalAddEvaluator.close();
  }
}
