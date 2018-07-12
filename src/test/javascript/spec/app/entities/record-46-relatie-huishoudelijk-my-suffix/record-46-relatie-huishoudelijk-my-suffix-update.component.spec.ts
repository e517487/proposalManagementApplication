/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record46RelatieHuishoudelijkMySuffixUpdateComponent } from 'app/entities/record-46-relatie-huishoudelijk-my-suffix/record-46-relatie-huishoudelijk-my-suffix-update.component';
import { Record46RelatieHuishoudelijkMySuffixService } from 'app/entities/record-46-relatie-huishoudelijk-my-suffix/record-46-relatie-huishoudelijk-my-suffix.service';
import { Record46RelatieHuishoudelijkMySuffix } from 'app/shared/model/record-46-relatie-huishoudelijk-my-suffix.model';

describe('Component Tests', () => {
    describe('Record46RelatieHuishoudelijkMySuffix Management Update Component', () => {
        let comp: Record46RelatieHuishoudelijkMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record46RelatieHuishoudelijkMySuffixUpdateComponent>;
        let service: Record46RelatieHuishoudelijkMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record46RelatieHuishoudelijkMySuffixUpdateComponent]
            })
                .overrideTemplate(Record46RelatieHuishoudelijkMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record46RelatieHuishoudelijkMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record46RelatieHuishoudelijkMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record46RelatieHuishoudelijkMySuffix(123);
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
                    const entity = new Record46RelatieHuishoudelijkMySuffix();
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
