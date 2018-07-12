/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Record10AanvraagGegevensAlgemeenService } from 'app/entities/record-10-aanvraag-gegevens-algemeen/record-10-aanvraag-gegevens-algemeen.service';
import { Record10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';
import { SERVER_API_URL } from 'app/app.constants';

describe('Service Tests', () => {
    describe('Record10AanvraagGegevensAlgemeen Service', () => {
        let injector: TestBed;
        let service: Record10AanvraagGegevensAlgemeenService;
        let httpMock: HttpTestingController;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule]
            });
            injector = getTestBed();
            service = injector.get(Record10AanvraagGegevensAlgemeenService);
            httpMock = injector.get(HttpTestingController);
        });

        describe('Service methods', () => {
            it('should call correct URL', () => {
                service.find(123).subscribe(() => {});

                const req = httpMock.expectOne({ method: 'GET' });

                const resourceUrl = SERVER_API_URL + 'api/record-10-aanvraag-gegevens-algemeens';
                expect(req.request.url).toEqual(resourceUrl + '/' + 123);
            });

            it('should create a Record10AanvraagGegevensAlgemeen', () => {
                service.create(new Record10AanvraagGegevensAlgemeen(null)).subscribe(received => {
                    expect(received.body.id).toEqual(null);
                });

                const req = httpMock.expectOne({ method: 'POST' });
                req.flush({ id: null });
            });

            it('should update a Record10AanvraagGegevensAlgemeen', () => {
                service.update(new Record10AanvraagGegevensAlgemeen(123)).subscribe(received => {
                    expect(received.body.id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'PUT' });
                req.flush({ id: 123 });
            });

            it('should return a Record10AanvraagGegevensAlgemeen', () => {
                service.find(123).subscribe(received => {
                    expect(received.body.id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush({ id: 123 });
            });

            it('should return a list of Record10AanvraagGegevensAlgemeen', () => {
                service.query(null).subscribe(received => {
                    expect(received.body[0].id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush([new Record10AanvraagGegevensAlgemeen(123)]);
            });

            it('should delete a Record10AanvraagGegevensAlgemeen', () => {
                service.delete(123).subscribe(received => {
                    expect(received.url).toContain('/' + 123);
                });

                const req = httpMock.expectOne({ method: 'DELETE' });
                req.flush(null);
            });

            it('should propagate not found response', () => {
                service.find(123).subscribe(null, (_error: any) => {
                    expect(_error.status).toEqual(404);
                });

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush('Invalid request parameters', {
                    status: 404,
                    statusText: 'Bad Request'
                });
            });
        });

        afterEach(() => {
            httpMock.verify();
        });
    });
});
