import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantaddComponent } from './restaurantadd.component';

describe('RestaurantaddComponent', () => {
  let component: RestaurantaddComponent;
  let fixture: ComponentFixture<RestaurantaddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantaddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
