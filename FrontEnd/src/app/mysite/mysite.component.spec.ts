import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MysiteComponent } from './mysite.component';

describe('MysiteComponent', () => {
  let component: MysiteComponent;
  let fixture: ComponentFixture<MysiteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MysiteComponent]
    });
    fixture = TestBed.createComponent(MysiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
