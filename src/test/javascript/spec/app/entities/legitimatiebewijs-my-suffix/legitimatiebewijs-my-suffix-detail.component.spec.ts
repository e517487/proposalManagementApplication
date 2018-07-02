/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { LegitimatiebewijsMySuffixDetailComponent } from 'app/entities/legitimatiebewijs-my-suffix/legitimatiebewijs-my-suffix-detail.component';
import { LegitimatiebewijsMySuffix } from 'app/shared/model/legitimatiebewijs-my-suffix.model';

describe('Component Tests', () => {
    describe('LegitimatiebewijsMySuffix Management Detail Component', () => {
        let comp: LegitimatiebewijsMySuffixDetailComponent;
        let fixture: ComponentFixture<LegitimatiebewijsMySuffixDetailComponent>;
        const route = ({ data: of({ legitimatiebewijs: new LegitimatiebewijsMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [LegitimatiebewijsMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(LegitimatiebewijsMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(LegitimatiebewijsMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.legitimatiebewijs).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
