/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { KredietAanvraagMySuffixService } from 'app/entities/krediet-aanvraag-my-suffix/krediet-aanvraag-my-suffix.service';
import { KredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';
import { SERVER_API_URL } from 'app/app.constants';

describe('Service Tests', () => {
    describe('KredietAanvraagMySuffix Service', () => {
        let injector: TestBed;
        let service: KredietAanvraagMySuffixService;
        let httpMock: HttpTestingController;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule]
            });
            injector = getTestBed();
            service = injector.get(KredietAanvraagMySuffixService);
            httpMock = injector.get(HttpTestingController);
        });

        describe('Service methods', () => {
            it('should call correct URL', () => {
                service.find(123).subscribe(() => {});

                const req = httpMock.expectOne({ method: 'GET' });

                const resourceUrl = SERVER_API_URL + 'api/krediet-aanvraags';
                expect(req.request.url).toEqual(resourceUrl + '/' + 123);
            });

            it('should create a KredietAanvraagMySuffix', () => {
                service.create(new KredietAanvraagMySuffix(null)).subscribe(received => {
                    expect(received.body.id).toEqual(null);
                });

                const req = httpMock.expectOne({ method: 'POST' });
                req.flush({ id: null });
            });

            it('should update a KredietAanvraagMySuffix', () => {
                service.update(new KredietAanvraagMySuffix(123)).subscribe(received => {
                    expect(received.body.id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'PUT' });
                req.flush({ id: 123 });
            });

            it('should return a KredietAanvraagMySuffix', () => {
                service.find(123).subscribe(received => {
                    expect(received.body.id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush({ id: 123 });
            });

            it('should return a list of KredietAanvraagMySuffix', () => {
                service.query(null).subscribe(received => {
                    expect(received.body[0].id).toEqual(123);
                });

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush([new KredietAanvraagMySuffix(123)]);
            });

            it('should delete a KredietAanvraagMySuffix', () => {
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
