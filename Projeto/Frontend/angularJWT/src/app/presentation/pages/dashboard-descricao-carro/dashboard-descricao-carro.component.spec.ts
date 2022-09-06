import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardDescricaoCarroComponent } from './dashboard-descricao-carro.component';

describe('DashboardDescricaoCarroComponent', () => {
  let component: DashboardDescricaoCarroComponent;
  let fixture: ComponentFixture<DashboardDescricaoCarroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardDescricaoCarroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardDescricaoCarroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
