package com.spring_28min.aop;

import com.spring_28min.service.ApplicationContextConfiguration;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * The test for {@link HiBeyAspect}
 *
 * @author Andrei Khadziukou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class HiBeyAspectTest {

    @Autowired
    private HiBeyAspect aspect;

    @Test
    public void testBefore() {
        aspect.before(new JoinPointImpl());
    }

    @Test
    public void testBeforeWithArgs() throws Exception {
        aspect.beforeWithArgs(new JoinPointImpl());
    }

    @Test
    public void testAfter() throws Exception {
        aspect.after(new JoinPointImpl());
    }

    @Test
    public void testAfterReturningValue() throws Exception {
        aspect.afterReturning(new JoinPointImpl(), "Test");
    }

    // The bad sample of the mocking object (use easymock, mockito)
    private static class JoinPointImpl implements JoinPoint {

        @Override
        public String toShortString() {
            return null;
        }

        @Override
        public String toLongString() {
            return null;
        }

        @Override
        public Object getThis() {
            return null;
        }

        @Override
        public Object getTarget() {
            return null;
        }

        @Override
        public Object[] getArgs() {
            return new Object[0];
        }

        @Override
        public Signature getSignature() {
            return new Signature() {
                @Override
                public String toShortString() {
                    return null;
                }

                @Override
                public String toLongString() {
                    return null;
                }

                @Override
                public String getName() {
                    return "mocked name";
                }

                @Override
                public int getModifiers() {
                    return 0;
                }

                @Override
                public Class getDeclaringType() {
                    return null;
                }

                @Override
                public String getDeclaringTypeName() {
                    return null;
                }
            };
        }

        @Override
        public SourceLocation getSourceLocation() {
            return null;
        }

        @Override
        public String getKind() {
            return null;
        }

        @Override
        public StaticPart getStaticPart() {
            return null;
        }
    }
}
