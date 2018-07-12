/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record62UitlegDeleteDialogComponent } from 'app/entities/record-62-uitleg/record-62-uitleg-delete-dialog.component';
import { Record62UitlegService } from 'app/entities/record-62-uitleg/record-62-uitleg.service';

describe('Component Tests', () => {
    describe('Record62Uitleg Management Delete Component', () => {
        let comp: Record62UitlegDeleteDialogComponent;
        let fixture: ComponentFixture<Record62UitlegDeleteDialogComponent>;
        let service: Record62UitlegService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record62UitlegDeleteDialogComponent]
            })
                .overrideTemplate(Record62UitlegDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record62UitlegDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record62UitlegService);
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
