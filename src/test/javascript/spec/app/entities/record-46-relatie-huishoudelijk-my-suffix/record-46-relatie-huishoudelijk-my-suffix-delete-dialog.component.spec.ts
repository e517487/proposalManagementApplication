/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent } from 'app/entities/record-46-relatie-huishoudelijk-my-suffix/record-46-relatie-huishoudelijk-my-suffix-delete-dialog.component';
import { Record46RelatieHuishoudelijkMySuffixService } from 'app/entities/record-46-relatie-huishoudelijk-my-suffix/record-46-relatie-huishoudelijk-my-suffix.service';

describe('Component Tests', () => {
    describe('Record46RelatieHuishoudelijkMySuffix Management Delete Component', () => {
        let comp: Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent>;
        let service: Record46RelatieHuishoudelijkMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record46RelatieHuishoudelijkMySuffixService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it(
                'Should call delete service on confirmDelete',
                inject(
                    [],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });
});
