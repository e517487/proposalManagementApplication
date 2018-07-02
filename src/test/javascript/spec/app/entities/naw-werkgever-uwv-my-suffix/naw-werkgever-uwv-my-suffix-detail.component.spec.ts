/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { NawWerkgeverUWVMySuffixDetailComponent } from 'app/entities/naw-werkgever-uwv-my-suffix/naw-werkgever-uwv-my-suffix-detail.component';
import { NawWerkgeverUWVMySuffix } from 'app/shared/model/naw-werkgever-uwv-my-suffix.model';

describe('Component Tests', () => {
    describe('NawWerkgeverUWVMySuffix Management Detail Component', () => {
        let comp: NawWerkgeverUWVMySuffixDetailComponent;
        let fixture: ComponentFixture<NawWerkgeverUWVMySuffixDetailComponent>;
        const route = ({ data: of({ nawWerkgeverUWV: new NawWerkgeverUWVMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [NawWerkgeverUWVMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(NawWerkgeverUWVMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(NawWerkgeverUWVMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.nawWerkgeverUWV).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
