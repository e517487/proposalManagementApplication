/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record46RelatieHuishoudelijkUpdateComponent } from 'app/entities/record-46-relatie-huishoudelijk/record-46-relatie-huishoudelijk-update.component';
import { Record46RelatieHuishoudelijkService } from 'app/entities/record-46-relatie-huishoudelijk/record-46-relatie-huishoudelijk.service';
import { Record46RelatieHuishoudelijk } from 'app/shared/model/record-46-relatie-huishoudelijk.model';

describe('Component Tests', () => {
    describe('Record46RelatieHuishoudelijk Management Update Component', () => {
        let comp: Record46RelatieHuishoudelijkUpdateComponent;
        let fixture: ComponentFixture<Record46RelatieHuishoudelijkUpdateComponent>;
        let service: Record46RelatieHuishoudelijkService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record46RelatieHuishoudelijkUpdateComponent]
            })
                .overrideTemplate(Record46RelatieHuishoudelijkUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record46RelatieHuishoudelijkUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record46RelatieHuishoudelijkService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record46RelatieHuishoudelijk(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record46RelatieHuishoudelijk = entity;
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
                    const entity = new Record46RelatieHuishoudelijk();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record46RelatieHuishoudelijk = entity;
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
