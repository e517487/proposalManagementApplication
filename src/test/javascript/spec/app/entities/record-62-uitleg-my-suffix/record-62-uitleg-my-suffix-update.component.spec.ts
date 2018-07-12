/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record62UitlegMySuffixUpdateComponent } from 'app/entities/record-62-uitleg-my-suffix/record-62-uitleg-my-suffix-update.component';
import { Record62UitlegMySuffixService } from 'app/entities/record-62-uitleg-my-suffix/record-62-uitleg-my-suffix.service';
import { Record62UitlegMySuffix } from 'app/shared/model/record-62-uitleg-my-suffix.model';

describe('Component Tests', () => {
    describe('Record62UitlegMySuffix Management Update Component', () => {
        let comp: Record62UitlegMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record62UitlegMySuffixUpdateComponent>;
        let service: Record62UitlegMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record62UitlegMySuffixUpdateComponent]
            })
                .overrideTemplate(Record62UitlegMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record62UitlegMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record62UitlegMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record62UitlegMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record62Uitleg = entity;
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
                    const entity = new Record62UitlegMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record62Uitleg = entity;
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
