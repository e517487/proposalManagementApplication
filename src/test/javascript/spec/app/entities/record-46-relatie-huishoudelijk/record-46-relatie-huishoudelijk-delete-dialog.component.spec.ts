/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record46RelatieHuishoudelijkDeleteDialogComponent } from 'app/entities/record-46-relatie-huishoudelijk/record-46-relatie-huishoudelijk-delete-dialog.component';
import { Record46RelatieHuishoudelijkService } from 'app/entities/record-46-relatie-huishoudelijk/record-46-relatie-huishoudelijk.service';

describe('Component Tests', () => {
    describe('Record46RelatieHuishoudelijk Management Delete Component', () => {
        let comp: Record46RelatieHuishoudelijkDeleteDialogComponent;
        let fixture: ComponentFixture<Record46RelatieHuishoudelijkDeleteDialogComponent>;
        let service: Record46RelatieHuishoudelijkService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record46RelatieHuishoudelijkDeleteDialogComponent]
            })
                .overrideTemplate(Record46RelatieHuishoudelijkDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record46RelatieHuishoudelijkDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record46RelatieHuishoudelijkService);
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
