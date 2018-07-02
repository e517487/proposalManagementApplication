/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { NawWerkgeverUWVMySuffixUpdateComponent } from 'app/entities/naw-werkgever-uwv-my-suffix/naw-werkgever-uwv-my-suffix-update.component';
import { NawWerkgeverUWVMySuffixService } from 'app/entities/naw-werkgever-uwv-my-suffix/naw-werkgever-uwv-my-suffix.service';
import { NawWerkgeverUWVMySuffix } from 'app/shared/model/naw-werkgever-uwv-my-suffix.model';

describe('Component Tests', () => {
    describe('NawWerkgeverUWVMySuffix Management Update Component', () => {
        let comp: NawWerkgeverUWVMySuffixUpdateComponent;
        let fixture: ComponentFixture<NawWerkgeverUWVMySuffixUpdateComponent>;
        let service: NawWerkgeverUWVMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [NawWerkgeverUWVMySuffixUpdateComponent]
            })
                .overrideTemplate(NawWerkgeverUWVMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(NawWerkgeverUWVMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(NawWerkgeverUWVMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new NawWerkgeverUWVMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.nawWerkgeverUWV = entity;
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
                    const entity = new NawWerkgeverUWVMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.nawWerkgeverUWV = entity;
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
