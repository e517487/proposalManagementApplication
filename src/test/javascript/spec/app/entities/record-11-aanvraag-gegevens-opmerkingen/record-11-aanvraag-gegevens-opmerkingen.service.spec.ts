/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Record11AanvraagGegevensOpmerkingenService } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen/record-11-aanvraag-gegevens-opmerkingen.service';
import { Record11AanvraagGegevensOpmerkingen } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen.model';
import { SERVER_API_URL } from 'app/app.constants';

describe('Service Tests', () => {
    describe('Record11AanvraagGegevensOpmerkingen Service', () => {
        let injector: TestBed;
        let service: Record11AanvraagGegevensOpmerkingenService;
        let httpMock: HttpTestingController;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule]
            });
            injector = getTestBed();
            service = injector.get(Record11AanvraagGegevensOpmerkingenService);
            httpMock = injector.get(HttpTestingController);
        });

        describe('Service methods', () => {
            it('should call correct URL', () => {
                service.find(123).subscribe(() => {});

                const req = httpMock.expectOne({ method: 'GET' });

                const resourceUrl = SERVER_API_URL + 'api/record-11-aanvraag-gegevens-opmerkingens';
                expect(req.request.url).toEqual(resourceUrl + '/' + 123);
            });

            it('should create a Record11AanvraagGegevensOpmerkingen', () => {
                service.create(new Record11AanvraagGegevensOpmerkingen(null)).subscribe(received => {
                    expect(received.body.id).toEqual(null);
                });

                const req = httpMock.expectOne({ method: 'POST' });
                req.flush({ id: null });
            });

            it('should update a Record11AanvraagGegevensOpmerkingen', () => {
                service.update(new Record11AanvraagGegevensOpmerkingen(123)).subscribe(received => {
                    expect(received.body.id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'PUT' });
                req.flush({ id: 123 });
            });

            it('should return a Record11AanvraagGegevensOpmerkingen', () => {
                service.find(123).subscribe(received => {
                    expect(received.body.id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush({ id: 123 });
            });

            it('should return a list of Record11AanvraagGegevensOpmerkingen', () => {
                service.query(null).subscribe(received => {
                    expect(received.body[0].id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush([new Record11AanvraagGegevensOpmerkingen(123)]);
            });

            it('should delete a Record11AanvraagGegevensOpmerkingen', () => {
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
