/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { KredietAanvraagMySuffixDeleteDialogComponent } from 'app/entities/krediet-aanvraag-my-suffix/krediet-aanvraag-my-suffix-delete-dialog.component';
import { KredietAanvraagMySuffixService } from 'app/entities/krediet-aanvraag-my-suffix/krediet-aanvraag-my-suffix.service';

describe('Component Tests', () => {
    describe('KredietAanvraagMySuffix Management Delete Component', () => {
        let comp: KredietAanvraagMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<KredietAanvraagMySuffixDeleteDialogComponent>;
        let service: KredietAanvraagMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [KredietAanvraagMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(KredietAanvraagMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(KredietAanvraagMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(KredietAanvraagMySuffixService);
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
