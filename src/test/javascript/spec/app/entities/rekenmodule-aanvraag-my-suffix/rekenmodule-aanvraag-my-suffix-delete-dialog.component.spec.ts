/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { RekenmoduleAanvraagMySuffixDeleteDialogComponent } from 'app/entities/rekenmodule-aanvraag-my-suffix/rekenmodule-aanvraag-my-suffix-delete-dialog.component';
import { RekenmoduleAanvraagMySuffixService } from 'app/entities/rekenmodule-aanvraag-my-suffix/rekenmodule-aanvraag-my-suffix.service';

describe('Component Tests', () => {
    describe('RekenmoduleAanvraagMySuffix Management Delete Component', () => {
        let comp: RekenmoduleAanvraagMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<RekenmoduleAanvraagMySuffixDeleteDialogComponent>;
        let service: RekenmoduleAanvraagMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [RekenmoduleAanvraagMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(RekenmoduleAanvraagMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(RekenmoduleAanvraagMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RekenmoduleAanvraagMySuffixService);
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
