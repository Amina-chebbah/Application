import {Component, OnInit} from '@angular/core';
import {RobotService} from '../../services/robot.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-robot',
  templateUrl: './robot.component.html',
  styleUrls: ['./robot.component.css'],
})
export class RobotComponent implements OnInit {

  public optimizedResult;
  public actualResult;
  public optimizedProcessed = false;
  public actualProcessed = false;
  public form: FormGroup;

  constructor(private robotService: RobotService, private fb: FormBuilder) {
  }

  ngOnInit() {
    this.createForm();
  }


  createForm() {
    this.form = this.fb.group({
      chaineArticle: ['', Validators.required]
    });
  }


  onSubmit() {
    // stop here if form is invalid
    if (this.form.invalid) {
      alert('veuillez saisir une chaine d\'article');
    }

    this.robotService.getOpimized(this.form.get('chaineArticle').value).subscribe(
      data => {
        console.log('OPTIMIZED', data);
        this.optimizedResult = this.processData(data);
        this.optimizedProcessed = true;
      }
    );

    this.robotService.getActual(this.form.get('chaineArticle').value).subscribe(
      data => {
        console.log('ACTUAL', data);
        this.actualResult = this.processData(data);
        this.actualProcessed = true;
      }
    );
  }

  processData(data: string[]): string {
    let result = '';
    data.forEach((element, idx) => {
      result += element;
      if (idx !== data.length - 1) {
        result += '/';
      }
    });

    return result + ' => ' + data.length + ' cartons utilisés';
  }

}
