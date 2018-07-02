/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { AanvraagberichtMySuffixUpdateComponent } from 'app/entities/aanvraagbericht-my-suffix/aanvraagbericht-my-suffix-update.component';
import { AanvraagberichtMySuffixService } from 'app/entities/aanvraagbericht-my-suffix/aanvraagbericht-my-suffix.service';
import { AanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';

describe('Component Tests', () => {
    describe('AanvraagberichtMySuffix Management Update Component', () => {
        let comp: AanvraagberichtMySuffixUpdateComponent;
        let fixture: ComponentFixture<AanvraagberichtMySuffixUpdateComponent>;
        let service: AanvraagberichtMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [AanvraagberichtMySuffixUpdateComponent]
            })
                .overrideTemplate(AanvraagberichtMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AanvraagberichtMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AanvraagberichtMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new AanvraagberichtMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.aanvraagbericht = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new AanvraagberichtMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.aanvraagbericht = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
