/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { GezinssituatieMySuffixDeleteDialogComponent } from 'app/entities/gezinssituatie-my-suffix/gezinssituatie-my-suffix-delete-dialog.component';
import { GezinssituatieMySuffixService } from 'app/entities/gezinssituatie-my-suffix/gezinssituatie-my-suffix.service';

describe('Component Tests', () => {
    describe('GezinssituatieMySuffix Management Delete Component', () => {
        let comp: GezinssituatieMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<GezinssituatieMySuffixDeleteDialogComponent>;
        let service: GezinssituatieMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [GezinssituatieMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(GezinssituatieMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(GezinssituatieMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(GezinssituatieMySuffixService);
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
