/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { AdresMySuffixDeleteDialogComponent } from 'app/entities/adres-my-suffix/adres-my-suffix-delete-dialog.component';
import { AdresMySuffixService } from 'app/entities/adres-my-suffix/adres-my-suffix.service';

describe('Component Tests', () => {
    describe('AdresMySuffix Management Delete Component', () => {
        let comp: AdresMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<AdresMySuffixDeleteDialogComponent>;
        let service: AdresMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [AdresMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(AdresMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AdresMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AdresMySuffixService);
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
