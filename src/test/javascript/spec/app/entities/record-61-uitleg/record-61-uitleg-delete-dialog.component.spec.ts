/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record61UitlegDeleteDialogComponent } from 'app/entities/record-61-uitleg/record-61-uitleg-delete-dialog.component';
import { Record61UitlegService } from 'app/entities/record-61-uitleg/record-61-uitleg.service';

describe('Component Tests', () => {
    describe('Record61Uitleg Management Delete Component', () => {
        let comp: Record61UitlegDeleteDialogComponent;
        let fixture: ComponentFixture<Record61UitlegDeleteDialogComponent>;
        let service: Record61UitlegService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record61UitlegDeleteDialogComponent]
            })
                .overrideTemplate(Record61UitlegDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record61UitlegDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record61UitlegService);
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
