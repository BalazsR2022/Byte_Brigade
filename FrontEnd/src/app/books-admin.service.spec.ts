import { TestBed } from '@angular/core/testing';

import { BooksAdminService } from './books-admin.service';

describe('BooksAdminService', () => {
  let service: BooksAdminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BooksAdminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
