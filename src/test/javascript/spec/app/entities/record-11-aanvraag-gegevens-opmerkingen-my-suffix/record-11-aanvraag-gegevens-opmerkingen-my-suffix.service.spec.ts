/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Record11AanvraagGegevensOpmerkingenMySuffixService } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen-my-suffix/record-11-aanvraag-gegevens-opmerkingen-my-suffix.service';
import { Record11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';
import { SERVER_API_URL } from 'app/app.constants';

describe('Service Tests', () => {
    describe('Record11AanvraagGegevensOpmerkingenMySuffix Service', () => {
        let injector: TestBed;
        let service: Record11AanvraagGegevensOpmerkingenMySuffixService;
        let httpMock: HttpTestingController;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule]
            });
            injector = getTestBed();
            service = injector.get(Record11AanvraagGegevensOpmerkingenMySuffixService);
            httpMock = injector.get(HttpTestingController);
        });

        describe('Service methods', () => {
            it('should call correct URL', () => {
                service.find(123).subscribe(() => {});

                const req = httpMock.expectOne({ method: 'GET' });

                const resourceUrl = SERVER_API_URL + 'api/record-11-aanvraag-gegevens-opmerkingens';
                expect(req.request.url).toEqual(resourceUrl + '/' + 123);
            });

            it('should create a Record11AanvraagGegevensOpmerkingenMySuffix', () => {
                service.create(new Record11AanvraagGegevensOpmerkingenMySuffix(null)).subscribe(received => {
                    expect(received.body.id).toEqual(null);
                });

                const req = httpMock.expectOne({ method: 'POST' });
                req.flush({ id: null });
            });

            it('should update a Record11AanvraagGegevensOpmerkingenMySuffix', () => {
                service.update(new Record11AanvraagGegevensOpmerkingenMySuffix(123)).subscribe(received => {
                    expect(received.body.id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'PUT' });
                req.flush({ id: 123 });
            });

            it('should return a Record11AanvraagGegevensOpmerkingenMySuffix', () => {
                service.find(123).subscribe(received => {
                    expect(received.body.id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush({ id: 123 });
            });

            it('should return a list of Record11AanvraagGegevensOpmerkingenMySuffix', () => {
                service.query(null).subscribe(received => {
                    expect(received.body[0].id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush([new Record11AanvraagGegevensOpmerkingenMySuffix(123)]);
            });

            it('should delete a Record11AanvraagGegevensOpmerkingenMySuffix', () => {
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
